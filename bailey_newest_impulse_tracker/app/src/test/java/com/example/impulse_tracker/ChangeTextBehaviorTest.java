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
            = new ActivityTestRule<>(DummyContent.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        stringToBetyped = "Espresso";
    }

    @Test
    public void getText() {
        // Create new DummyContent object
        DummyContent test = new DummyContent(0, "content", "details");

        assertEquals(test.id, 0);
        assertEquals(test.content, "content");
        assertEquals(test.description, "details");
    }
}
