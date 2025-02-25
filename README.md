# FollowerBot (Headless Mode)

A Java-based Selenium automation bot designed to automate the signup process for the MavenX platform using a **headless browser**. This enables the bot to run efficiently without rendering the browser UI, ideal for background tasks or CI/CD pipelines.

---

## Features

- Automates the signup process on the MavenX platform.
- Dynamically generates unique email addresses and usernames.
- Runs in **headless mode** for efficient, non-UI-based automation.
- Utilizes Selenium WebDriver for interacting with web elements.
- Handles dynamic web elements with explicit waits.

---

## Prerequisites

1. **Java Development Kit (JDK)**:
   - Ensure you have JDK 8 or later installed.
   - Verify by running: `java -version`.

2. **ChromeDriver**:
   - Download the [ChromeDriver](https://chromedriver.chromium.org/) compatible with your browser version.
   - Place the `chromedriver.exe` file in a directory (e.g., `C:\Chrome Webdriver`).

3. **Maven** (Optional):
   - If using Maven, ensure it’s installed and configured.

4. **Dependencies**:
   - Add the Selenium library to your project.
   - If using Maven, include the following in your `pom.xml`:
     ```xml
     <dependency>
       <groupId>org.seleniumhq.selenium</groupId>
       <artifactId>selenium-java</artifactId>
       <version>4.27.0</version>
     </dependency>
     ```

---

## How to Run the Project

### 1. Clone the Repository
```bash
git clone https://github.com/tekywhet/BotForSignup.git
cd BotForSignup
