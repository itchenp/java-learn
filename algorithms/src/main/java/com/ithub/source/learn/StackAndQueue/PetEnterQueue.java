package com.ithub.source.learn.StackAndQueue;

public class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getEntryPetType(){
        return this.pet.getPetType();
    }
}
