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

|   Attributes   	|   Type   	| isRequired 	|            Note           	|
|:--------------:	|:--------:	|:----------:	|:-------------------------:	|
|      text      	|  String  	|    True    	|                           	|
|    duration    	|    int   	|    True    	| 0 = SHORT<br><br>1 = LONG 	|
|      style     	| ModToast 	|    False   	|  ROUND<br>FLAT<br>BORDER  	|
| backgroundTint 	| int/null 	|    False   	|     Index for resource    	|
|    textColor   	| int/null 	|    False   	|     Index for resource    	|
|    imageRes    	| int/null 	|    False   	|     Index for resource    	|



License
--------

    Copyright 2013 Square, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



