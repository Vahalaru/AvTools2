package com.example.jerem.avtools;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Open_plane extends AppCompatActivity {
    String pid;
    String passedplaneid;
    String passedPlaneName;
    String passedPlaneType;
    String passedPlaneClass;
    String passedPlaneStyle;
    String passedPlaneNotes;
    String passedPlaneJetLo;
    String handFee;
    String pdClass;
    String imgurl;
    FloatingActionButton fabEdit;
    ImageView selected_plane_image;
    ImageView imageView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_plane);


        TextView openplanename = (TextView) findViewById(R.id.opname);
        TextView openplanetype = (TextView) findViewById(R.id.optype);
        TextView openplanestyle = (TextView) findViewById(R.id.opstyle);
        TextView openplanenotes = (TextView) findViewById(R.id.opnotes);
        TextView openplaneclass = (TextView) findViewById(R.id.handFee);

        passedplaneid = getIntent().getStringExtra("id");
        passedPlaneName = getIntent().getStringExtra("pname");
        passedPlaneType = getIntent().getStringExtra("ptype");
        passedPlaneClass = getIntent().getStringExtra("pclass");
        passedPlaneStyle = getIntent().getStringExtra("pstyle");
        passedPlaneNotes = getIntent().getStringExtra("pnotes");
        passedPlaneJetLo = getIntent().getStringExtra("pjetlo");

        pid = passedplaneid;
        pdClass = passedPlaneClass;
        handelingFee();

        imgurl = "http://www.broprogramming.com/avtoolsapp/img/"+passedPlaneName+".jpg";

        imageView = (ImageView) findViewById(R.id.imageView);

        Picasso.with(Open_plane.this)
                .load(imgurl)
                .transform(new RoundedTransormation())
                //.fit()
                //.centerCrop()
                .into(imageView);

        openplanename.setText(passedPlaneName);
        openplanetype.setText(passedPlaneType);
        openplanestyle.setText(passedPlaneStyle);
        openplanenotes.setText(passedPlaneNotes);
        openplaneclass.setText("Min. Fuel " + handFee + " gal. or Handeling Fee of $" + handFee);

        fabEdit = (FloatingActionButton) findViewById(R.id.fab);
        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PlaneUpdate.class);
                i.putExtra("id", pid);
                i.putExtra("pname", passedPlaneName);
                i.putExtra("ptype", passedPlaneType);
                i.putExtra("pclass", passedPlaneClass);
                i.putExtra("pstyle", passedPlaneStyle);
                i.putExtra("pnotes", passedPlaneNotes);
                i.putExtra("pjetlo", passedPlaneJetLo);
                startActivity(i);
            }
        });
    }

    public String handelingFee() {
        if ("Single".equals(pdClass)) {
            handFee = "10";
        } else if ("Single Turbo Prop".equals(pdClass)) {
            handFee = "60";
        } else if ("Turbo Prop".equals(pdClass)) {
            handFee = "100";
        } else if ("Heavy Turbo Prop".equals(pdClass)) {
            handFee = "350";
        } else if ("Narrow Body".equals(pdClass)) {
            handFee = "600";
        } else if ("Light Twin".equals(pdClass)) {
            handFee = "20";
        } else if ("Heavy Twin".equals(pdClass)) {
            handFee = "30";
        } else if ("Very Light Jet".equals(pdClass)) {
            handFee = "60";
        } else if ("Light Jet".equals(pdClass)) {
            handFee = "140";
        } else if ("Medium Jet".equals(pdClass)) {
            handFee = "150";
        } else if ("Heavy Jet".equals(pdClass)) {
            handFee = "230";
        } else if ("Extra Heavy Jet".equals(pdClass)) {
            handFee = "385";
        } else {
            handFee = pdClass;
        }
        return handFee;
    }

    public class RoundedTransormation implements com.squareup.picasso.Transformation {
        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());

            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
            if (squaredBitmap != source) {
                source.recycle();
            }

            Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            BitmapShader shader = new BitmapShader(squaredBitmap,
                    BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setAntiAlias(true);

            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);

            squaredBitmap.recycle();
            return bitmap;
        }

        @Override
        public String key() {
            return "circle";
        }
    }
}
