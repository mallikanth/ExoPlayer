/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * TXXX (User defined text information) ID3 frame.
 */
public final class TxxxFrame extends Id3Frame {

  public static final String ID = "TXXX";

  public final String description;
  public final String value;

  public TxxxFrame(String description, String value) {
    super(ID);
    this.description = description;
    this.value = value;
  }

  public TxxxFrame(Parcel in) {
    super(in);
    description = in.readString();
    value = in.readString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TxxxFrame that = (TxxxFrame) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (description != null ? !description.equals(that.description) : that.description != null)
      return false;
    return value != null ? value.equals(that.value) : that.value == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(id);
    dest.writeString(description);
    dest.writeString(value);
  }

  public static final Parcelable.Creator<TxxxFrame> CREATOR =
      new Parcelable.Creator<TxxxFrame>() {

        @Override
        public TxxxFrame createFromParcel(Parcel in) {
          return new TxxxFrame(in);
        }

        @Override
        public TxxxFrame[] newArray(int size) {
          return new TxxxFrame[size];
        }

      };

}
