package development.alberto.com.rxjava2_mvp.case1;


import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import development.alberto.com.rxjava2_mvp.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    //Test to check the views that are displaying
    @Test
    public void mainActivityShouldCheckElementsDisplayedTest() {
        assertNotNull(onView(withId(R.id.splashImage)));
        assertNotNull(onView(withId(R.id.list)));
        assertNotNull(onView(withId(R.id.title)));
        assertNotNull(onView(withId(R.id.movieImage)));
        assertNotNull(onView(withId(R.id.release)));

    }
    //Test to display the recycler view positions and click on one item of the Recycler view
    @Test
    public void mainActivityShouldDisplayRecyclerViewTest() {
        //scrolling positions
        onView(withId(R.id.list)).perform(scrollToPosition(0));
        onView(withId(R.id.list)).perform(scrollToPosition(1));
        onView(withId(R.id.list)).perform(scrollToPosition(2));
        onView(withId(R.id.list)).perform(scrollToPosition(3));
        onView(withId(R.id.list)).perform(scrollToPosition(4));
        onView(withId(R.id.list)).perform(scrollToPosition(5));
        onView(withId(R.id.list)).perform(scrollToPosition(6));
        onView(withId(R.id.list)).perform(scrollToPosition(7));
        onView(withId(R.id.list)).perform(scrollToPosition(8));
        onView(withId(R.id.list)).perform(scrollToPosition(9));
        onView(withId(R.id.list)).perform(scrollToPosition(10));

        // Click item at position 3
        onView(withId(R.id.list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));

    }

    //Method to return a new instance for using the customized Recycler View Matcher
    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

    //Standard Matcher
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
