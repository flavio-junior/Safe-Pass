package br.com.safe.pass.ui.utils

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.pm.PackageInfoCompat
import br.com.safe.pass.ui.model.AppVersion

class VersionApp(val context: Context) {

    fun getVersionApp(): AppVersion {
        val packageManager = context.packageManager
        val packageName = context.packageName
        val packageInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0))
        } else {
            packageManager.getPackageInfo(packageName, 0)
        }
        return AppVersion(
            versionName = packageInfo.versionName,
            versionNumber = PackageInfoCompat.getLongVersionCode(packageInfo),
        )
    }
}
