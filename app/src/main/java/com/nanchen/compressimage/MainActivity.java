package com.nanchen.compressimage;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nanchen.compresshelper.CompressHelper;
import com.nanchen.compresshelper.FileUtil;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity{

    private ImageView mImageOld;
    private ImageView mImageNew;

    private static final int PICK_IMAGE_REQUEST = 1;
    private TextView mTextOld;
    private TextView mTextNew;

    private File oldFile;
    private File newFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();

    }

    private void initInstances() {
        mImageOld = (ImageView) findViewById(R.id.main_image_old);
        mImageNew = (ImageView) findViewById(R.id.main_image_new);
        mTextOld = (TextView) findViewById(R.id.main_text_old);
        mTextNew = (TextView) findViewById(R.id.main_text_new);
    }

    public void compress(View view) {
        // 默认的压缩方法，多张图片只需要直接加入循环即可
        newFile = CompressHelper.getDefault(this).compressToFile(oldFile);


//        String yourFileName = "123.jpg";
//
//        // 你也可以自定义压缩
//        newFile = new CompressHelper.Builder(this)
//                .setMaxWidth(720)  // 默认最大宽度为720
//                .setMaxHeight(960) // 默认最大高度为960
//                .setQuality(80)    // 默认压缩质量为80
//                .setCompressFormat(CompressFormat.JPEG) // 设置默认压缩为jpg格式
//                .setFileName(yourFileName) // 设置你的文件名
//                .setDestinationDirectoryPath(Environment.getExternalStoragePublicDirectory(
//                        Environment.DIRECTORY_PICTURES).getAbsolutePath())
//                .build()
//                .compressToFile(oldFile);


        mImageNew.setImageBitmap(BitmapFactory.decodeFile(newFile.getAbsolutePath()));
        mTextNew.setText(String.format("Size : %s", getReadableFileSize(newFile.length())));
    }

    public void takePhoto(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK) {
            if (data == null) {
                showError("Failed to open picture!");
                return;
            }
            try {
                oldFile = FileUtil.getTempFile(this, data.getData());
                mImageOld.setImageBitmap(BitmapFactory.decodeFile(oldFile.getAbsolutePath()));
                mTextOld.setText(String.format("Size : %s", getReadableFileSize(oldFile.length())));
                clearImage();
            } catch (IOException e) {
                showError("Failed to read picture data!");
                e.printStackTrace();
            }
        }
    }

    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    private int getRandomColor() {
        Random rand = new Random();
        return Color.argb(100, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }


    private void clearImage() {
        mImageOld.setBackgroundColor(getRandomColor());
        mImageNew.setImageDrawable(null);
        mImageNew.setBackgroundColor(getRandomColor());
        mTextNew.setText("Size : -");
    }


    public String getReadableFileSize(long size) {
        if (size <= 0) {
            return "0";
        }
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }
}
