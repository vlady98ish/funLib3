
# FunFactsLoadingLibrary

FunFactsLoadingView is a custom Android view that displays random fun facts every 15 seconds. The view comes with several customizable options such as font style, size, family, and a custom background image. The fun facts are fetched from a provided API.

## Installation

To add this library to your project, add the following dependency to your app level `build.gradle` file:

```groovy
dependencies {
    implementation 'com.github.vlady98ish:funLib3:1.0.0'
}
```

# Usage
XML 

Include the FunFactsLoadingView in your layout file:
```xml
<com.github.vlady98ish.funLib3.FunFactsLoadingView
    android:id="@+id/funFactsLoadingView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:backgroundImage="@drawable/your_background"
    app:fontFamily="sans-serif-light"
    app:fontStyle="normal"
    app:textSize="18sp" />
```

# Programmatic

You can also set the properties programmatically:




# FunFactsLoadingView

FunFactsLoadingView is a custom Android view that displays random fun facts every 15 seconds. The view comes with several customizable options such as font style, size, family, and a custom background image. The fun facts are fetched from a provided API.

## Installation

To add this library to your project, add the following dependency to your app level `build.gradle` file:

```groovy
dependencies {
    implementation 'com.github.vlady98ish:funLib3:1.0.0'
}
```

# Usage
XML 

Include the FunFactsLoadingView in your layout file:
```xml
<com.github.vlady98ish.funLib3.FunFactsLoadingView
    android:id="@+id/funFactsLoadingView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:backgroundImage="@drawable/your_background"
    app:fontFamily="sans-serif-light"
    app:fontStyle="normal"
    app:textSize="18sp" />
```

# Programmatic

You can also set the properties programmatically:

```code
FunFactsLoadingView funFactsLoadingView = findViewById(R.id.funFactsLoadingView);
funFactsLoadingView.setBackgroundImage(getResources().getDrawable(R.drawable.your_background, null));
funFactsLoadingView.setFontFamily("sans-serif-light");
funFactsLoadingView.setFontStyle(Typeface.NORMAL);
funFactsLoadingView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
```

# Customization

The FunFactsLoadingView offers several options for customization:

* **app:backgroundImage:** Set a custom background image.
* **app:fontFamily:** Set a custom font family.
* **app:fontStyle:** Set the font style (normal, bold, italic).
* **app:textSize:** Set the size of the text.




# FunFactsLoadingView

FunFactsLoadingView is a custom Android view that displays random fun facts every 15 seconds. The view comes with several customizable options such as font style, size, family, and a custom background image. The fun facts are fetched from a provided API.

## Installation

To add this library to your project, add the following dependency to your app level `build.gradle` file:

```groovy
dependencies {
    implementation 'com.github.vlady98ish:funLib3:1.0.0'
}
```

# Usage
XML 

Include the FunFactsLoadingView in your layout file:
```xml
<com.github.vlady98ish.funLib3.FunFactsLoadingView
    android:id="@+id/funFactsLoadingView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:backgroundImage="@drawable/your_background"
    app:fontFamily="sans-serif-light"
    app:fontStyle="normal"
    app:textSize="18sp" />
```

# Programmatic

You can also set the properties programmatically:



## License

[MIT](https://choosealicense.com/licenses/mit/)
