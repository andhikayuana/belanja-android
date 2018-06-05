package id.yuana.belanja.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.zxing.Result;

import id.yuana.belanja.scanner.data.model.Product;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jun, Tue 05 2018 10.42
 **/
public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;

    public static Intent newIntent(Context context) {
        return new Intent(context, ScannerActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        startActivity(ProductDetailActivity.newIntent(this, Product.parseFromJson(result.getText())));
    }
}
