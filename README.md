

# FunFactsLoadingLibrary

FunFactsLoadingView is a custom Android view that displays random fun facts every 15 seconds. The view comes with several customizable options such as font style, size, family, and a custom background image. The fun facts are fetched from a provided API.

## Installation

To add this library to your project, add the following dependency to your app level `build.gradle` file:

```groovy
dependencies {
    implementation 'com.github.vlady98ish:funLib3:1.0.8'
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
    app:customFontFamily="sans-serif-light"
    app:customFontStyle="normal"
    app:customFontSize="18sp" />
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
* **app:customFontFamily:** Set a custom font family.
* **app:customFontStyle:** Set the font style (normal, bold, italic).
* **app:customFontSize:** Set the size of the text.


## License

[MIT](https://choosealicense.com/licenses/mit/)
