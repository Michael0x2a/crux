package com.chimbori.snacktroid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Parsed result from web page containing important title, text and image.
 *
 * All fields are public for performance reasons on Android.
 * @link https://developer.android.com/training/articles/perf-tips.html#GettersSetters
 *
 * Avoid Internal Getters/Setters
 *
 * In native languages like C++ it's common practice to use getters (i = getCount()) instead of
 * accessing the field directly (i = mCount). This is an excellent habit for C++ and is often
 * practiced in other object oriented languages like C# and Java, because the compiler can usually
 * inline the access, and if you need to restrict or debug field access you can add the code at any
 * time.
 *
 * However, this is a bad idea on Android. Virtual method calls are expensive, much more so than
 * instance field lookups. It's reasonable to follow common object-oriented programming practices
 * and have getters and setters in the public interface, but within a class you should always
 * access fields directly.
 *
 * Without a JIT, direct field access is about 3x faster than invoking a trivial getter. With the
 * JIT (where direct field access is as cheap as accessing a local), direct field access is about
 * 7x faster than invoking a trivial getter.
 */
class ParsedResult {
  public String title = "";
  public String url = "";
  public String originalUrl = "";
  public String canonicalUrl = "";
  public String imageUrl = "";
  public String videoUrl = "";
  public String rssUrl = "";
  public String text = "";
  public String faviconUrl = "";
  public String description = "";
  public String dateString = "";
  public List<String> textList = new ArrayList<>();
  public Collection<String> keywords;
  public List<ImageResult> images = new ArrayList<>();

  @Override
  public String toString() {
    return "ParsedResult{" +
        "title='" + title + '\'' +
        ", url='" + url + '\'' +
        ", originalUrl='" + originalUrl + '\'' +
        ", canonicalUrl='" + canonicalUrl + '\'' +
        ", imageUrl='" + imageUrl + '\'' +
        ", videoUrl='" + videoUrl + '\'' +
        ", rssUrl='" + rssUrl + '\'' +
        ", text='" + text + '\'' +
        ", faviconUrl='" + faviconUrl + '\'' +
        ", description='" + description + '\'' +
        ", dateString='" + dateString + '\'' +
        ", textList=" + textList +
        ", keywords=" + keywords +
        ", images=" + images +
        '}';
  }
}
