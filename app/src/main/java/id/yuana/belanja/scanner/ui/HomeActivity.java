package id.yuana.belanja.scanner.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import id.yuana.belanja.scanner.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        btnScanner = findViewById(R.id.btnScanner);
        btnScanner.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnScanner) {
            startActivity(ScannerActivity.newIntent(this));
        }
    }
}
