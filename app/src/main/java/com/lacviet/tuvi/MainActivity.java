package com.lacviet.tuvi;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = new WebView(this);
        setContentView(webView);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

        // The local app page uses this bridge only for its explicit PDF/JPG export action.
        webView.addJavascriptInterface(new AndroidFiles(), "AndroidFiles");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();
                // Open the banking app / Zalo / other external links outside the local WebView.
                if (url.startsWith("https://dl.vietqr.io") || !url.startsWith("file://")) {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    } catch (Exception ignored) {
                    }
                }
                return false;
            }
        });

        webView.loadUrl("file:///android_asset/index.html");
    }

    private class AndroidFiles {
        @JavascriptInterface
        public void saveBase64File(String base64, String mimeType, String fileName) {
            runOnUiThread(() -> {
                try {
                    byte[] bytes = Base64.decode(base64, Base64.DEFAULT);
                    String safeName = fileName == null ? "TuVi_LacHong_export" : fileName.replaceAll("[^a-zA-Z0-9._-]", "_");
                    String lower = safeName.toLowerCase();
                    if (!lower.endsWith(".jpg") && !lower.endsWith(".jpeg") && !lower.endsWith(".pdf")) {
                        safeName += ".bin";
                    }
                    saveExport(bytes, mimeType, safeName);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Không thể lưu tệp: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void saveExport(byte[] bytes, String mimeType, String fileName) throws Exception {
        String type = (mimeType == null || mimeType.trim().isEmpty())
                ? "application/octet-stream" : mimeType;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContentValues values = new ContentValues();
            values.put(MediaStore.MediaColumns.DISPLAY_NAME, fileName);
            values.put(MediaStore.MediaColumns.MIME_TYPE, type);
            values.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS + "/TuViLacHong");
            values.put(MediaStore.MediaColumns.IS_PENDING, 1);

            Uri itemUri = getContentResolver().insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, values);
            if (itemUri == null) {
                throw new IllegalStateException("Không tạo được tệp trong thư mục Download.");
            }

            try (OutputStream output = getContentResolver().openOutputStream(itemUri)) {
                if (output == null) throw new IllegalStateException("Không mở được luồng ghi tệp.");
                output.write(bytes);
                output.flush();
            } catch (Exception e) {
                getContentResolver().delete(itemUri, null, null);
                throw e;
            }

            ContentValues ready = new ContentValues();
            ready.put(MediaStore.MediaColumns.IS_PENDING, 0);
            getContentResolver().update(itemUri, ready, null, null);
            Toast.makeText(this, "Đã lưu vào Download/TuViLacHong/" + fileName, Toast.LENGTH_LONG).show();
        } else {
            // Android 6–9: save in the app-specific Downloads folder (no storage permission needed).
            File root = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (root == null) throw new IllegalStateException("Thiết bị không có vùng lưu trữ khả dụng.");
            File folder = new File(root, "TuViLacHong");
            if (!folder.exists() && !folder.mkdirs()) {
                throw new IllegalStateException("Không tạo được thư mục lưu tệp.");
            }
            File outputFile = new File(folder, fileName);
            try (FileOutputStream output = new FileOutputStream(outputFile)) {
                output.write(bytes);
                output.flush();
            }
            Toast.makeText(this, "Đã lưu tệp: " + outputFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
