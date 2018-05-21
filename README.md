# ebutuoy

A hybrid mobile application designed as a clone of `youtube`. Currently, it

- searches youtube for a query string provided by the user
- shows search results
- plays selected video

It has been bundled via `cordova` to be packaged as an android/iOS app. It can trivially also be bundled as a desktop app using `electron`.

## Development

### Compile css:

Compile css file once.

```
lein garden once
```

Automatically recompile css file on change.

```
lein garden auto
```

CSS also gets automatically built when running `lein build` and recompiled on change with `lein dev`.

### Run application:

```
lein dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

### Run tests:

```
lein clean
lein doo phantom test once
```

The above command assumes that you have [phantomjs](https://www.npmjs.com/package/phantomjs) installed. However, please note that [doo](https://github.com/bensu/doo) can be configured to run cljs.test in many other JS environments (chrome, ie, safari, opera, slimer, node, rhino, or nashorn).

## Production Build

To compile clojurescript to javascript:

```
lein build
```
