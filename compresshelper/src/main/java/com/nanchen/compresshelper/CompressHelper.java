package com.nanchen.compresshelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;


import java.io.File;

import rx.Observable;
import rx.functions.Func0;

/**
 * 压缩方法工具类
 *
 * Author: nanchen
 * Email: liushilin520@foxmail.com
 * Date: 2017-03-08  9:03
 */

public class CompressHelper {
    private static volatile CompressHelper INSTANCE;
    private Context context;
    //max width and height values of the compressed image is taken as 612x816
    private float maxWidth = 612.0f;
    private float maxHeight = 816.0f;
    private Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
    private Bitmap.Config bitmapConfig = Bitmap.Config.ARGB_8888;
    private int quality = 80;
    private String destinationDirectoryPath;
    private String fileNamePrefix;
    private String fileName;


    private CompressHelper(Context context) {
        this.context = context;
        destinationDirectoryPath = context.getCacheDir().getPath() + File.pathSeparator + FileUtil.FILES_PATH;
    }

    public static CompressHelper getDefault(Context context) {
        if (INSTANCE == null) {
            synchronized (CompressHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CompressHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 压缩成文件
     * @param file  原始文件
     * @return      压缩后的文件
     */
    public File compressToFile(File file) {
        return ImageUtil.compressImage(context, Uri.fromFile(file), maxWidth, maxHeight,
                compressFormat, bitmapConfig, quality, destinationDirectoryPath,
                fileNamePrefix, fileName);
    }

    /**
     * 压缩为Bitmap
     * @param file  原始文件
     * @return      压缩后的Bitmap
     */
    public Bitmap compressToBitmap(File file) {
        return ImageUtil.getScaledBitmap(context, Uri.fromFile(file), maxWidth, maxHeight, bitmapConfig);
    }

    public Observable<File> compressToFileAsObservable(final File file) {
        return Observable.defer(new Func0<Observable<File>>() {
            @Override
            public Observable<File> call() {
                return Observable.just(compressToFile(file));
            }
        });
    }

    public Observable<Bitmap> compressToBitmapAsObservable(final File file) {
        return Observable.defer(new Func0<Observable<Bitmap>>() {
            @Override
            public Observable<Bitmap> call() {
                return Observable.just(compressToBitmap(file));
            }
        });
    }

    public static class Builder {
        private CompressHelper mCompressHelper;

        public Builder(Context context) {
            mCompressHelper = new CompressHelper(context);
        }

        public Builder setMaxWidth(float maxWidth) {
            mCompressHelper.maxWidth = maxWidth;
            return this;
        }

        public Builder setMaxHeight(float maxHeight) {
            mCompressHelper.maxHeight = maxHeight;
            return this;
        }

        public Builder setCompressFormat(Bitmap.CompressFormat compressFormat) {
            mCompressHelper.compressFormat = compressFormat;
            return this;
        }

        public Builder setBitmapConfig(Bitmap.Config bitmapConfig) {
            mCompressHelper.bitmapConfig = bitmapConfig;
            return this;
        }

        public Builder setQuality(int quality) {
            mCompressHelper.quality = quality;
            return this;
        }

        public Builder setDestinationDirectoryPath(String destinationDirectoryPath) {
            mCompressHelper.destinationDirectoryPath = destinationDirectoryPath;
            return this;
        }

        public Builder setFileNamePrefix(String prefix) {
            mCompressHelper.fileNamePrefix = prefix;
            return this;
        }

        public Builder setFileName(String fileName) {
            mCompressHelper.fileName = fileName;
            return this;
        }

        public CompressHelper build() {
            return mCompressHelper;
        }
    }
}
