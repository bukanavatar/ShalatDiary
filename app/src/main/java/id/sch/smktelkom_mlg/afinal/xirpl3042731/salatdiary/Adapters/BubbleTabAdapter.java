package id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages.JadwalShalatFragment;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages.KalenderShalatFragment;
import id.sch.smktelkom_mlg.afinal.xirpl3042731.salatdiary.Pages.ProfilFragment;
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
                return JadwalShalatFragment.newInstance();
            case 1:
                return StatistikShalatFragment.newInstance();
            case 2:
                return TambahkanShalatFragment.newInstance();
            case 3:
                return KalenderShalatFragment.newInstance();
            case 4:
                return ProfilFragment.newInstance();
            default:
                return JadwalShalatFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
