# ModToast

Quickly and easily create a custom toast on Android

[![](https://jitpack.io/v/AlfredoHdez1709/ModToast.svg)](https://jitpack.io/#AlfredoHdez1709/ModToast)

## ScreenShoot

Style Round

![](https://s3.gifyu.com/images/modtoast_01.gif)

Style Border with icon

![](https://s3.gifyu.com/images/modtoast_02.gif)

Style Flat

![](https://s3.gifyu.com/images/modtoast_03.gif)

Style basic

![](https://s3.gifyu.com/images/modtoast_04.gif)

## Integration

### Add it in your root build.gradle at the end of repositories:

    allprojects {
        repositories {
          ...
          maven { url 'https://jitpack.io' }
        }
      }
### Add the dependency

      dependencies {
                implementation 'com.github.AlfredoHdez1709:ModToast:0.1'
        }

## Implementation   
   #### Basic implementation
   
        ModToast("This is ModToast", 0)

   #### Full implementation
        
        ModToast("This is ModToast", 
                0, 
                ModToast.FLAT, 
                android.R.color.black, 
                android.R.color.white ,
                R.drawable.ic_android_black_24dp)
                
## Attributes

| Attributes     	| Type     	| isRequired 	| Note                      	|
|----------------	|----------	|------------	|---------------------------	|
| text           	| String   	| True       	|                           	|
| duration       	| int      	| True       	| 0 = SHORT<br><br>1 = LONG 	|
| style          	| ModToast 	| False      	| ROUND<br>FLAT<br>BORDER   	|
| backgroundTint 	| int/null 	| False      	| Index for resource        	|
| textColor      	| int/null 	| False      	| Index for resource        	|
| imageRes       	| int/null 	| False      	| Index for resource        	|
