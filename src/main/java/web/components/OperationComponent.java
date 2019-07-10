package main.java.web.components;

import org.springframework.stereotype.Component;

@Component
public class OperationComponent {
    public int add(int a, int b) {
        return a + b;
    }
}
