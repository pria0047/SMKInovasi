package pria.com.smkinovasi.Tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import pria.com.smkinovasi.R;
import pria.com.smkinovasi.fragment.AboutFragment;
import pria.com.smkinovasi.fragment.HomeFragment;
import pria.com.smkinovasi.fragment.OlehFragment;
import pria.com.smkinovasi.fragment.SejarahFragment;

/**
 * Created by pwsfans on 28/05/2017.
 */

public class MyAdapter extends FragmentPagerAdapter {
    int[] icon = new int[]{R.drawable.ic_account_balance_white_24dp, R.drawable.ic_nature_people_white_24dp, R.drawable.ic_local_grocery_store_white_24dp, R.drawable.ic_people_white_24dp};
    private Context mContext;
    private String[] titles = {"A", "B", "C", "D"};
    private int heightIcon;

    public MyAdapter(FragmentManager fm, Context c) {
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon = (int) (24 * scale + 0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;

        if (position == 0) {
            frag = new SejarahFragment();
        } else if (position == 1) {
            frag = new HomeFragment();
        } else if (position == 2) {
            frag = new OlehFragment();
        } else if (position == 3) {
            frag = new AboutFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position) {
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0, 0, heightIcon, heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is, 0, sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }
}