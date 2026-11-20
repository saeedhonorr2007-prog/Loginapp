# LoginApp — اپلیکیشن اندروید صفحه ورود

یک پروژه ساده و آموزشی اندروید با **Kotlin** که شامل دو صفحه است:

1. **صفحه ورود (MainActivity)** — کاربر نام کاربری و رمز عبور را وارد می‌کند.
2. **صفحه خوش‌آمد (WelcomeActivity)** — در صورت ورود موفق باز می‌شود و **نام کاربری** را نمایش می‌دهد؛ در صورت اشتباه بودن، **پیام خطا** نمایش داده می‌شود.

## مشخصات ورود پیش‌فرض

| فیلد | مقدار |
|------|-------|
| نام کاربری | `mobile` |
| رمز عبور | `1234` |

> نکته: رمز عبور با ارقام فارسی (۱۲۳۴) هم پذیرفته می‌شود، چون کد به‌صورت خودکار ارقام فارسی/عربی را به ارقام انگلیسی تبدیل می‌کند.

## امکانات

- ورود با احراز هویت ساده (بدون سرور — مناسب آموزش)
- نمایش پیام خطای درون‌صفحه‌ای در صورت اشتباه بودن اطلاعات
- نمایش نام کاربری در صفحه دوم
- دکمه «خروج از حساب» برای بازگشت به صفحه ورود
- پشتیبانی کامل از **راست‌چین (RTL)** و زبان فارسی
- طراحی مینیمال با Material 3 (کارت سفید، دکمه آبی، فیلدهای Outlined)
- مخفی/نمایش رمز با آیکون چشم در فیلد رمز عبور

## ساختار پروژه

```
LoginApp/
├── app/
│   ├── build.gradle
│   ├── proguard-rules.pro
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/example/loginapp/
│       │   ├── MainActivity.kt        ← صفحه ورود و منطق بررسی رمز
│       │   └── WelcomeActivity.kt     ← صفحه دوم و نمایش نام کاربری
│       └── res/
│           ├── layout/
│           │   ├── activity_main.xml
│           │   └── activity_welcome.xml
│           ├── values/
│           │   ├── strings.xml        ← همه متن‌های فارسی
│           │   ├── colors.xml
│           │   └── themes.xml
│           ├── drawable/              ← لوگو و پس‌زمینه خطا
│           └── mipmap-*/              ← آیکون اپلیکیشن
├── build.gradle
├── settings.gradle
├── gradle.properties
├── gradle/wrapper/
└── .gitignore
```

## تکنولوژی‌ها

- زبان: **Kotlin**
- رابط کاربری: **XML + Material Components 3**
- حداقل نسخه اندروید: **API 24 (اندروید ۷)**
- نسخه کامپایل: **API 35** — اندروید ۱۵
- Gradle 8.9 + Android Gradle Plugin 8.7.3

## نحوه اجرا در Android Studio

1. Android Studio را باز کنید (نسخه Jellyfish (2023.3) یا جدیدتر توصیه می‌شود).
2. از منوی **File → Open** پوشه `LoginApp` را انتخاب کنید.
3. صبر کنید تا Gradle Sync تمام شود (بار اول ممکن است چند دقیقه طول بکشد).
4. دکمه **Run ▶** را بزنید تا اپ روی شبیه‌ساز یا گوشی اجرا شود.

## ساخت APK از خط فرمان

```bash
# نسخه Debug
./gradlew assembleDebug
# خروجی: app/build/outputs/apk/debug/app-debug.apk

# نسخه Release (امضادار)
./gradlew assembleRelease
```

## تغییر نام کاربری و رمز عبور

فایل `app/src/main/java/com/example/loginapp/MainActivity.kt` را باز کنید و در بخش `companion object` مقادیر را عوض کنید:

```kotlin
companion object {
    private const val USERNAME = "mobile"
    private const val PASSWORD = "1234"
}
```

## انتشار در گیت‌هاب

اگر پروژه را دانلود کردید و می‌خواهید در یک ریپوی جدید بگذارید:

```bash
cd LoginApp
git init
git add .
git commit -m "Initial commit: Android login app"
git branch -M main
git remote add origin https://github.com/USERNAME/REPO-NAME.git
git push -u origin main
```

### نکات امنیتی مهم

- هرگز **توکن دسترسی (PAT)** یا رمز خود را داخل فایل‌های پروژه قرار ندهید؛ فایل `.gitignore` جلوی فایل‌های محلی و بیلدشده را می‌گیرد، اما مسئولیت فایل‌های اضافه با خودتان است.
- توکن گیت‌هاب را فقط هنگام `git push` وارد کنید (گیت آن را در فایل پروژه ذخیره نمی‌کند).
- اگر توکنی را در گفتگو یا چت عمومی به اشتراک گذاشتید، بعد از پایان کار حتماً از [تنظیمات توکن‌های گیت‌هاب](https://github.com/settings/tokens) آن را **Revoke/Regenerate** کنید.
