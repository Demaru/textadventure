package streambolics.textAdventure;

/*---------------------------------------------------------------------------------------------------

 Part of : Text Adventure Creator

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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TextAdventureStart extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.main);
        Button btn;
        btn = (Button) findViewById (R.id.Button_Play);
        btn.setOnClickListener (new View.OnClickListener ()
        {
            @Override
            public void onClick (View v)
            {
                startRoomActivity ();
            }
        });
        btn = (Button) findViewById (R.id.Button_Restart);
        btn.setOnClickListener (new View.OnClickListener ()
        {
            @Override
            public void onClick (View v)
            {
                restartRoomActivity ();
            }
        });
    }

    @Override
    public void onResume ()
    {
        super.onResume ();
        TextView v = (TextView) findViewById (R.id.TextView_Description);
        try
        {
            InputStream in = openFileInput ("BuiltIn.Autosave.save");
            InputStreamReader tmp = new InputStreamReader (in);
            BufferedReader reader = new BufferedReader (tmp);
            String str;
            StringBuffer buf = new StringBuffer ();
            while ((str = reader.readLine ()) != null)
            {
                buf.append (str + '\n');
            }
            in.close ();
            v.setText (buf.toString ());
        }
        catch (Exception e)
        {
        }

    }

    public void restartAdventure ()
    {
        deleteFile ("BuiltIn.Autosave.save");
    }

    public void restartRoomActivity ()
    {
        new AlertDialog.Builder (this).setTitle ("Restart?").setMessage ("Really restart at the beginning?")
                .setPositiveButton ("Yes, restart", new DialogInterface.OnClickListener ()
                {
                    @Override
                    public void onClick (DialogInterface dialog, int which)
                    {
                        restartAdventure ();
                        startRoomActivity ();
                    }
                }).setNegativeButton ("Hell no !", new DialogInterface.OnClickListener ()
                {
                    @Override
                    public void onClick (DialogInterface dialog, int which)
                    {
                    }
                }).show ();

    }

    public void startRoomActivity ()
    {
        startActivity (new Intent (this, TextAdventureRoom.class));
    }
}