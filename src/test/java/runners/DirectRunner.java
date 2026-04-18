package runners;

import io.cucumber.core.cli.Main;

public class DirectRunner {
    public static void main(String[] args) {
        String[] argv = {
                "--glue", "steps",
                "--plugin", "pretty",
                "--plugin", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "src/test/resources/features"
        };
        Main.run(argv, Thread.currentThread().getContextClassLoader());
    }
}