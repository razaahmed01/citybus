package com.example.busapp;

    public class busadapter {
        int id;
        String name;

        public busadapter(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public busadapter(){}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
