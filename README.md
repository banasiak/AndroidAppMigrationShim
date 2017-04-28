AndroidAppMigrationShim
=======================

### What?
This "shim" app can be used to point your current install base users to a new app in the Google Play store.  Once the user installs the new app, this shim will receive a broadcast notification and prompt the user to uninstall the shim.

### Why?
Let's say you inherited an app from another party. The app has previously been published to Google Play and the old owner was gracious enough to fill out the paperwork and get Google to transfer that app from their developer account into yours.  Congratulations!

However, you soon realize you can't publish any updates to this app because you don't have access to the original developer's app signing keystore. If you don't have access to the original signing credentials, you can't post any upgrades and the original install base is essentially abandoned.

The purpose of this shim is to be the final hoorah for the old version of the app.  Adjust the package names accordingly, compile and politely ask the original developer to sign this new app for you.  If he/she does, then you can post this to the store and users will be prompted to install the new app the first time they launch the app after installing the update.

### Seriously?
Unfortunately, yes.
