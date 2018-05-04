package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages.JadwalShalatFragment;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages.KalenderShalatFragment;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages.StatistikShalatFragment;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages.TambahkanShalatFragment;

public class BubbleTabAdapter extends FragmentStatePagerAdapter {

    public BubbleTabAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return TambahkanShalatFragment.newInstance();
            case 1:
                return KalenderShalatFragment.newInstance();
            case 2:
                return StatistikShalatFragment.newInstance();
            case 3:
                return JadwalShalatFragment.newInstance();
            default:
                return TambahkanShalatFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
