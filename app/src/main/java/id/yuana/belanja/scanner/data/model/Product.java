package id.yuana.belanja.scanner.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jun, Tue 05 2018 10.49
 **/
public class Product implements Parcelable {

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
    private int id;
    private String name;
    private Long price;
    private String image;

    public Product() {
    }

    protected Product(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.price = (Long) in.readValue(Long.class.getClassLoader());
        this.image = in.readString();
    }

    public static Product parseFromJson(String json) {
        Product product = new Product();
        try {
            JSONObject jsonObject = new JSONObject(json);
            product.setId(jsonObject.getInt("id"));
            product.setName(jsonObject.getString("name"));
            product.setPrice(jsonObject.getLong("price"));
            product.setImage(jsonObject.getString("image"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPriceString() {
        return String.valueOf(price);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeValue(this.price);
        dest.writeString(this.image);
    }
}
