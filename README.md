# CompressHelper
压缩，图片压缩，压缩Bitmap，Compress,CompressImage,CompressFile,CompressBitmap<br><br>

#### 笔者从零搭建Retrofit+Rx+MVP框架APP,欢迎关注：https://github.com/nanchen2251/AiYaGirl

主要通过尺寸压缩和质量压缩，以达到清晰度最优，该项目参考了[https://github.com/zetbaitsu/Compressor](https://github.com/zetbaitsu/Compressor) 的大部分代码，且在基础上修正了部分bug
## 效果图<br>
![](https://github.com/nanchen2251/CompressHelper/blob/master/111.png)

#### ⊙开源不易，希望给个star或者fork奖励
#### ⊙拥抱开源：https://github.com/nanchen2251/

## 特点
  1、支持压缩单张图片和多张图片<br>
## 使用方法
#### 1、添加依赖<br>
##### Step 1. Add it in your root build.gradle at the end of repositories:
```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
##### Step 2. Add the dependency
```java
dependencies {
	        compile 'com.github.nanchen2251:CompressHelper:1.0.2'
	}
```
#### 2、在Activity里面使用<br>
```java
   File newFile = CompressHelper.getDefault(this).compressToFile(oldFile);
```
#### 3、你也可以自定义属性
```java
   File newFile = new CompressHelper.Builder(this)
                    .setMaxWidth(720)  // 默认最大宽度为720
                    .setMaxHeight(960) // 默认最大高度为960
                    .setQuality(80)    // 默认压缩质量为80
		    .setFileName(yourFileName) // 设置你需要修改的文件名
                    .setCompressFormat(CompressFormat.JPEG) // 设置默认压缩为jpg格式
                    .setDestinationDirectoryPath(Environment.getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_PICTURES).getAbsolutePath())
                    .build()
                    .compressToFile(oldFile);
```
该项目参考了：

* [https://github.com/zetbaitsu/Compressor](https://github.com/zetbaitsu/Compressor) 
* [https://github.com/Curzibn/Luban](https://github.com/Curzibn/Luban)


## 关于作者
    南尘<br>
    四川成都<br>
    [其它开源](https://github.com/nanchen2251/)<br>
    [博客园](http://www.cnblogs.com/liushilin/)
