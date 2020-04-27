package com.example.impulse_tracker;

import android.view.View;
import android.view.ViewParent;
import android.widget.TableLayout;
import android.widget.TableRow;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTests {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);


    static Matcher<View> atPositionInTable(final int x, final int y) {
        return new TypeSafeMatcher<View>(){

            @Override
            public void describeTo(Description description) {
                description.appendText("is at position # " + x + " , " + y);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent viewParent = view.getParent();
                if (!(viewParent instanceof TableRow)) {
                    return false;
                }
                TableRow row = (TableRow) viewParent;
                TableLayout table = (TableLayout) row.getParent();
                if (table.indexOfChild(row) != y)
                    return false;
                if (row.indexOfChild(view) == x)
                    return true;
                else
                    return false;
            }};
    }
    @Test
    public void testAddItem() {
        onView(withText("ADD ITEM")).perform(click());
        onView(withId(R.id.dateText))
                .perform(typeText("3/4/2020"), closeSoftKeyboard());
        onView(withId(R.id.costText))
                .perform(typeText("2020"), closeSoftKeyboard());
        onView(withId(R.id.descText))
                .perform(typeText("new toy"), closeSoftKeyboard());
        onView(withId(R.id.storeText))
                .perform(typeText("target"), closeSoftKeyboard());
        onView(withText("ADD")).perform(click());
        onView(withText("IMPULSE BUYS")).perform(click());

        //onView(atPositionInTable(0,0)).check(matches(withText("Date")));
        onView(atPositionInTable(0,2)).check(matches(withText("3/4/2020")));
        onView(atPositionInTable(1,2)).check(matches(withText("2020")));
        onView(atPositionInTable(2,2)).check(matches(withText("new toy")));
        onView(atPositionInTable(3,2)).check(matches(withText("target")));
        //onView(atPositionInTable(1,2)).check(doesNotExist());

    }
    @Test
    public void testAddDeleteItem() {
        onView(withText("ADD ITEM")).perform(click());
        onView(withId(R.id.dateText))
                .perform(typeText("02/20/2020"), closeSoftKeyboard());
        onView(withId(R.id.costText))
                .perform(typeText("2019"), closeSoftKeyboard());
        onView(withId(R.id.descText))
                .perform(typeText("cat litter"), closeSoftKeyboard());
        onView(withId(R.id.storeText))
                .perform(typeText("walmart"), closeSoftKeyboard());
        onView(withText("ADD")).perform(click());
        onView(withText("IMPULSE BUYS")).perform(click());
        onView(withText("DELETE LAST ")).perform(click());


        //onView(atPositionInTable(0,0)).check(matches(withText("Date")));

        //onView(atPositionInTable(0,2)).check(matches(withText("")));
        //onView(atPositionInTable(1,2)).check(matches(withText("20192018")));
        //onView(atPositionInTable(2,2)).check(matches(withText("cat littlercat treats")));
        //onView(atPositionInTable(3,2)).check(matches(withText("walmartwalmart")));
        //onView(atPositionInTable(1,2)).check(doesNotExist());

    }
}
