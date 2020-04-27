package com.example.android.testing.espresso.BasicSample;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ChangeTextBehaviorTest {

    private String stringToBetyped;

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(Tab2.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        stringToBetyped = "Espresso";
    }

    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.dateText))
                .perform(typeText(stringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.addButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.dateText))
                .check(matches(withText(stringToBetyped)));
    }
}
