/*-
 *  Copyright (C) 2016 Laurent Sebag
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.laurentsebag.wifitimer.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.analytics.Tracker;

import org.laurentsebag.wifitimer.WifiTimerApplication;
import org.laurentsebag.wifitimer.utils.TrackerUtils;

public abstract class TrackedActivity extends AppCompatActivity {
    protected Tracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WifiTimerApplication application = (WifiTimerApplication) getApplication();
        tracker = application.getDefaultTracker();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TrackerUtils.trackScreen(tracker, getClass().getSimpleName());
    }
}
