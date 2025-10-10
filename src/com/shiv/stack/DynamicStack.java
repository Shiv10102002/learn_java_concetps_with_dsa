package com.shiv.stack;

public class DynamicStack extends CustomStack{

    public DynamicStack(){
        super();
    }
    public DynamicStack(int size){
        super(size);
    }


    @Override
    public boolean push(int val) throws StackException{
        if(this.isFull()){
            int[] temp = new int[data.length*2];

            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
        // at this point we know stack is not empty
        //insert normally

        return super.push(val);
    }
}
