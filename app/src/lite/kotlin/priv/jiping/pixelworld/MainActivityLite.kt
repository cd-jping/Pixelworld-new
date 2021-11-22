package priv.jiping.pixelworld

import com.github.javiersantos.piracychecker.PiracyChecker
import dev.jahir.blueprint.ui.activities.DrawerBlueprintActivity

/**
 * You can choose between:
 * - DrawerBlueprintActivity
 * - BottomNavigationBlueprintActivity
 */

class MainActivityLite: DrawerBlueprintActivity() {

    /**
     * These things here have the default values. You can delete the ones you don't want to change
     * and/or modify the ones you want to.
     */
    override val billingEnabled = true

    override fun amazonInstallsEnabled(): Boolean = false
    override fun checkLPF(): Boolean = true
    override fun checkStores(): Boolean = true
    override val isDebug: Boolean = BuildConfig.DEBUG

    /**
     * This is your app's license key. Get yours on Google Play Dev Console.
     * Default one isn't valid and could cause issues in your app.
     */

    override fun getLicKey(): String? = "MIBIasdfwqefefgewg"


    /**
     * This is the license checker code. Feel free to create your own implementation or
     * leave it as it is.
     * Anyways, keep the 'destroyChecker()' as the very first line of this code block
     * Return null to disable license check
     */
    override fun getLicenseChecker(): PiracyChecker? {
        destroyChecker() // Important
//        return if (BuildConfig.DEBUG) null else super.getLicenseChecker()
        /**
         * 如果是debug版本 跳过许可证验证，否则 如果是Googleplay渠道 开启验证。其余不验证
         */
        return when {
            BuildConfig.DEBUG -> {
                null
            }
            BuildConfig.FLAVOR_Platform == "googleplay" -> {
                super.getLicenseChecker()
            }
            else -> null
        }
    }

    override fun defaultTheme(): Int = R.style.MyApp_Default
    override fun amoledTheme(): Int = R.style.MyApp_Default_Amoled
}
