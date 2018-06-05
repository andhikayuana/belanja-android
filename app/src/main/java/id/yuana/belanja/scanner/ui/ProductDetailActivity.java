package id.yuana.belanja.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import id.yuana.belanja.scanner.R;
import id.yuana.belanja.scanner.data.model.Product;

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jun, Tue 05 2018 10.43
 **/
public class ProductDetailActivity extends AppCompatActivity {

    private static final String EXTRA_DATA_PRODUCT = "EXTRA_DATA_PRODUCT";
    private Product product;
    private ImageView ivProductDetail;
    private TextView tvProductDetailName;
    private TextView tvProductDetailPrice;

    public static Intent newIntent(Context context, Product product) {
        Intent intent = new Intent(context, ProductDetailActivity.class);
        intent.putExtra(EXTRA_DATA_PRODUCT, product);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        initView();
        getDataFromIntent();
        showData();
    }

    private void initView() {
        ivProductDetail = findViewById(R.id.ivProductDetail);
        tvProductDetailName = findViewById(R.id.tvProductDetailName);
        tvProductDetailPrice = findViewById(R.id.tvProductDetailPrice);
    }

    private void getDataFromIntent() {
        product = getIntent().getParcelableExtra(EXTRA_DATA_PRODUCT);
    }

    private void showData() {
        tvProductDetailName.setText(product.getName());
        tvProductDetailPrice.setText(product.getPriceString());
        Picasso.get()
                .load(product.getImage())
                .placeholder(R.mipmap.ic_launcher_round)
                .into(ivProductDetail);
    }
}
