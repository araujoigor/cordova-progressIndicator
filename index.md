
Description
================

This plugin allows you to show a native *Progress Indicator* on iOS.
There are several types of indicators available:

* [Simple](#simple)
* [Determinate](#determinate)
* [Annular](#annular)
* [Bar](#bar)
* [Success](#showsuccess)
* [Simple Text](#showtext)



Installation
============


### Platforms

Current **this plugin supports iOS**, with plans to soon implement Android.


### Automatically

**Cordova** - To install this plugin simply type into the command line: (If you don't have the cordova CLI install using `npm install -g cordova`)
```bash
cordova plugin add https://github.com/pbernasconi/cordova-progressIndicator.git
```

**PhoneGap** - Installing this plugin is just as easy and requires this command:
```bash
phonegap local plugin add https://github.com/pbernasconi/cordova-progressIndicator.git
```


After installing in either Cordova or PhoneGap, simply run the two following commands to get your cordova app up and running:
```bash
cordova platform add [ios / android]
cordova build [ios / android]
```



### Manually

**I don't recommend** installing Cordova or PhoneGap plugins manually.
When a solution as simple as a one-liner CLI command is available, there is no point doing it the hard way.




Usage
=============

Using this Plugin is very simple. Once installed, you can call any type of indicator with `ProgressIndicator.*`

```javascript
ProgressIndicator.*
```

The `Simple` and `Success` indicators require the `.hide()` method to hide the window and allow the user to interact with the screen again. However, the `.hide()` method can be called at any moment with any indicator type.

```javascript
ProgressIndicator.hide()
```

Simple
------------

#### .showSimple()
Simple usage with no text.  Requires manual `hide()`.

```javascript
ProgressIndicator.showSimple(true)
```

![simple label](screenshots/simple.jpg)


> Param      |Type      |Default |Desc
> -----------|----------|--------|-----
>  **dim**    |*BOOL*    |false   | Dim Background

```javascript
ProgressIndicator.hide()
```


#### .showSimpleWithLabel()
Simple usage with a label. Requires manual `hide()`.


```javascript
ProgressIndicator.showSimpleWithLabel(false, 'Loading...')
```
![simple label](screenshots/simple-label.jpg)


> Param      |Type      |Default |Desc
> -----------|----------|--------|-----
> **dim**    |*BOOL*    |false   | Dim Background
> **label**  |*String*  | *null* | Label text

```javascript
ProgressIndicator.hide()
```



#### .showSimpleWithLabelDetail()
Simple usage with a label or with label and detail. Requires manual `hide()`.

```javascript
ProgressIndicator.showSimpleWithLabelDetail(false, 'Loading...', 'Refreshing list')
```

![simple label](screenshots/simple-label-detail.jpg)


> Param      |Type      |Default |Desc
> -----------|----------|--------|-----
> **dim**    |*BOOL*    |false   | Dim Background
> **label**  |*STRING*  |*null*    | Label text
> **detail** |*STRING*  | *null*   | Detail text

```javascript
ProgressIndicator.hide()
```

## Determinate


#### .showDeterminate()
Simple usage with a label or with label and detail. Hides automatically, upon timeout completion.

```javascript
ProgressIndicator.showDeterminate(false, 100000)
```
![simple label](screenshots/determinate-simple.jpg)


> Param      |Type      |Default |Desc
> -----------|----------|--------|-----
> **dim**    |*BOOL*    |false   | Dim Background
> **timeout**|*INTEGER* |50000   | Timeout in microseconds



#### .showDeterminateWithLabel()
Simple usage with a label or with label and detail. Hides automatically, upon timeout completion.

```javascript
ProgressIndicator.showDeterminateWithLabel(false, 50000, 'Loading...')
```

![simple label](screenshots/determinate-label.jpg)


> Param      |Type      |Default |Desc
> -----------|----------|--------|-----
> **dim**    |*BOOL*    |false   | Dim Background
> **timeout**|*INTEGER* |50000   | Timeout in microseconds
> **label**  |*STRING*  | *null*     | Label text


## Annular

#### .showAnnular()
Simple usage with a label or with label and detail. Requires manual `hide()`.

```javascript
ProgressIndicator.showAnnular(false, 100000)
```

![simple label](screenshots/annular-simple.jpg)


> Param      |Type      |Default |Desc
> -----------|----------|--------|-----
> **dim**    |*BOOL*    |false   | Dim Background
> **timeout**|*INTEGER* |50000   | Timeout in microseconds



#### .showAnnularWithLabel()
Simple usage with a label or with label and detail. Requires manual `hide()`.

```javascript
ProgressIndicator.showAnnularWithLabel(false, 50000, "Loading...")
```

![simple label](screenshots/annular-label.jpg)


> Param      |Type      |Default |Desc
> -----------|----------|--------|-----
> **dim**    |*BOOL*    |false   | Dim Background
> **timeout**|*INTEGER* |50000   | Timeout in microseconds
> **label**  |*STRING*  | *null*     | Label text


## Bar

#### .showBar()
Simple usage with a label or with label and detail. Requires manual `hide()`.

```javascript
ProgressIndicator.showBar(false, 100000)
```

![simple label](screenshots/bar-simple.jpg)


> Param      |Type      |Default |Desc
> -----------|----------|--------|-----
> **dim**    |*BOOL*    |false   | Dim Background
> **timeout**|*INTEGER* |50000   | Timeout in microseconds




#### .showBarWithLabel()
Simple usage with a label or with label and detail. Requires manual `hide()`.

```javascript
ProgressIndicator.showBarWithLabel(false, 50000, "Loading...")
```

![simple label](screenshots/bar-label.jpg)


> Param      |Type      |Default |Desc
> -----------|----------|--------|-----
> **dim**    |*BOOL*    |false   | Dim Background
> **timeout**|*INTEGER* |50000   | Timeout in microseconds
> **label**  |*STRING*  | *null* | Label text



## Others

#### .showSuccess()
Simple usage with a label or with label and detail. Requires manual `hide()`.

```javascript
ProgressIndicator.showSuccess(false)
```

![simple label](screenshots/success.jpg)


> Param      |Type      |Default |Desc
> -----------|----------|--------|-----
> **dim**    |*BOOL*    |false   | Dim Background
> **label**  |*STRING*  | *null*    | Label text


```javascript
ProgressIndicator.hide()
```

#### .showText()
Simple usage with a label or with label and detail. Requires manual `hide()`.

```javascript
ProgressIndicator.showText(false, "text goes here", 'top')
```

|![](screenshots/text-top.jpg)|![](screenshots/text-bottom.jpg)|


> Param      |Type      |Default |Desc
> -----------|----------|--------|-----
> **dim**    |*BOOL*    |false   | Dim Background
> **label**  |*STRING*  | *null*     | Label text
> **position**  |*STRING*  | "bottom"     | Position of text 'top', 'center', 'bottom'


```javascript
ProgressIndicator.hide()
```


CHANGELOG
===========

**1.0** - initial version supporting iOS

CREDITS
============

 - [MBProgressHUD](https://github.com/jdg/MBProgressHUD)
 - [Cordova-ActivityIndicator](https://github.com/Initsogar/cordova-activityindicator)


License
============

[The MIT License (MIT)](http://www.opensource.org/licenses/mit-license.html)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
