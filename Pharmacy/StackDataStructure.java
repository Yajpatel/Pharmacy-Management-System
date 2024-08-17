package Pharmacy;
public class StackDataStructure {
    Medicine[] stackArray;
    int capacity;
    int top;

    // Constructor to initialize the stack
    StackDataStructure(int size) {
        stackArray = new Medicine[size];
        capacity = size;
        top = -1;
    }

    // TO add Medicine object to the stack
    void push(Medicine med) {
        if (top >= capacity - 1) {
            System.out.println("Stack Overflow: Cannot add more medicines");
        } else {
            top++;
            stackArray[top] = med;
            // System.out.println(med.getMed_name() + " pushed onto stack");
        }
    }

    // Method to remove a Medicine object from the stack
    Medicine pop() {
        if (top == -1) {
            System.out.println("Stack Underflow: No medicines to remove");
            return null;
        } else {
            Medicine med = stackArray[top];
            // System.out.println(med.getMed_name() + " popped from stack");
            top--;
            return med;
        }
    }

    // Method to check if the stack is empty
    boolean isEmpty() {
        return top == -1;
    }

    // Method to see top 
    // void peep() {
    //     if (top == -1) {
    //         System.out.println("Stack is empty");
    //     } else {
    //         System.out.println("Top medicine: " + stackArray[top].getMed_name());
    //     }
    // }

}
