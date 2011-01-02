package streambolics.android;

/*---------------------------------------------------------------------------------------------------

 Part of : Generic tools for Android

 Copyright (C) 2010-2011  Stephan Leclercq

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.

 ---------------------------------------------------------------------------------------------------*/

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class Rotate180BitmapTransformation extends MatrixBitmapTransformation
{

    @Override
    public Bitmap transform (Bitmap aSource)
    {
        Matrix m = getMatrix ();
        m.setRotate (180);
        m.postTranslate (aSource.getWidth (), aSource.getHeight ());
        return super.transform (aSource);
    }
}