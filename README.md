# Software Development

## Building
You must have installed:
* Gradle 2.10 and above (works on Gradle 3 too)
* Java Developer Kit 8 with at least Update 40

Run this command to create an executable JavaFx-jar
```
gradle jfxJar
```

If you don't have gradle you can use the gradle wrapper

## Contributing
#### For Eclipse:

Required Dependencies:
* Java Developer Kit 8 with at least Update 40
* [e(fx)clipse](https://www.eclipse.org/efxclipse/install.html)
* [controlsfx-8.40 or higher](https://drive.google.com/open?id=1xPZVQ9CxLVQdcllQefO5LqmYZvXYvQaW)
* [jfeonix-8.0 or higher](https://drive.google.com/open?id=1xPZVQ9CxLVQdcllQefO5LqmYZvXYvQaW)
* [Scene Builder](http://gluonhq.com/products/scene-builder/#download) **Download Java8 Version**

Set up:
1. ```git clone https://github.com/AFHS-TSA/SoftwareDev-2017```
2. Open the newly cloned repository in eclipse.
3. Go to the project proporties or Alt-Enter and navigate to the Java Build Path.
4. Click Add external jars and select the controlsfx and jfeonix jar.
5. Click Apply and Close

**Note you may have to edit the .classpath file in order to fit your computer**

Setting up Scene Builder:
Once you have downloaded and installed Scene Builder you must import the jfeonix jar. 
1. In order to do this click the gear next to the library search bar. Then click JAR/FXML Manager. 
2. Then select Add Library/FXML from file system. 
3. You must then give it the path to your Scene Builder executable and import the elemnts.

If you followed these steps and recieved no errors then you are ready to work on the repository.


