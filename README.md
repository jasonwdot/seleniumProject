# seleniumtest
This is a quick project that targets the Sauce Labs Demo site to run some simple Selenium tests. Currently there are four (4) tests: two (2) Login tests and two (2) Inventory tests.

**Login Tests**:
- **successfulStandardUserLogin** - verifies a valid, active user is able to login successfully.
- **lockedOutUserLogin** - verifies a valid, inactive user is unable to log in.

**Inventory Tests**:
- **findAndVerifyBackpackInformation** - verifies the link for the Sauce Labs Backpack works properly and the details are correct.
- **findAndVerifyRedTShirtInformation** - verifies the link for the Red T-Shirt works properly and the details are correct.