package id.yuana.belanja.scanner.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import id.yuana.belanja.scanner.R;

public class HomeActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CAMERA = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        Button btnScanner = findViewById(R.id.btnScanner);
        btnScanner.setOnClickListener(this::onButtonScannerClick);
    }

    private void onButtonScannerClick(View v) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {

                showDialogNeedPermission();

            } else {
                requestPermission();
            }
        } else {
            openScannerActivity();
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CAMERA) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openScannerActivity();
            } else {
                showDialogNeedPermission();
            }
        }
    }

    private void showDialogNeedPermission() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.msg_need_permission)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                    dialog.dismiss();
                    requestPermission();
                })
                .create()
                .show();
    }

    private void openScannerActivity() {
        startActivity(ScannerActivity.newIntent(this));
    }
}
