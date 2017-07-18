# CompressHelper
压缩，图片压缩，压缩Bitmap，Compress,CompressImage,CompressFile,CompressBitmap<br><br>

#### 笔者从零搭建 Retrofit & RxJava & MVP 框架APP,欢迎关注：https://github.com/nanchen2251/AiYaGirl
#### 笔者最新 RxJava 2.x 教程系列代码，多多支持（含技术Blog）:https://github.com/nanchen2251/RxJava2Examples


主要通过尺寸压缩和质量压缩，以达到清晰度最优，该项目参考了[https://github.com/zetbaitsu/Compressor](https://github.com/zetbaitsu/Compressor) 的部分代码，且在基础上修正了部分bug
## 效果图<br>
![](https://github.com/nanchen2251/CompressHelper/blob/master/111.png)

#### ⊙开源不易，希望给个star或者fork奖励
#### ⊙拥抱开源：https://github.com/nanchen2251/
#### ⊙交流群（拒绝无脑问）：118116509

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
	        compile 'com.github.nanchen2251:CompressHelper:1.0.5'
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

### 关于作者
    南尘<br>
    四川成都<br>
    [其它开源](https://github.com/nanchen2251/)<br>
    [个人博客](https://nanchen2251.github.io/)<br>
    [简书](http://www.jianshu.com/u/f690947ed5a6)<br>
    [博客园](http://www.cnblogs.com/liushilin/)<br>
    交流群：118116509<br>
    欢迎投稿(关注)我的唯一公众号，公众号搜索 nanchen 或者扫描下方二维码：<br>
    ![](http://images2015.cnblogs.com/blog/845964/201707/845964-20170718083641599-1963842541.jpg)

    
#### 有码走遍天下 无码寸步难行（引自网络）

> 1024 - 梦想，永不止步!  
爱编程 不爱Bug  
爱加班 不爱黑眼圈  
固执 但不偏执  
疯狂 但不疯癫  
生活里的菜鸟  
工作中的大神  
身怀宝藏，一心憧憬星辰大海  
追求极致，目标始于高山之巅  
一群怀揣好奇，梦想改变世界的孩子  
一群追日逐浪，正在改变世界的极客  
你们用最美的语言，诠释着科技的力量  
你们用极速的创新，引领着时代的变迁  
  
------至所有正在努力奋斗的程序猿们！加油！！  
    
## Licenses
```
 Copyright 2017 nanchen(刘世麟)

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```
