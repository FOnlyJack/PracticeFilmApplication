package com.example.changemax.sqhappy.model.network.entity;

import java.util.List;

/**
 * Created by ChangeMax on 2017/3/14.
 * 演职员表
 */

public class FilmCreditsBean {

    private List<TypesBean> types;

    public List<TypesBean> getTypes() {
        return types;
    }

    public void setTypes(List<TypesBean> types) {
        this.types = types;
    }

    public static class TypesBean {

        private String typeName;
        private String typeNameEn;
        private List<PersonsBean> persons;

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeNameEn() {
            return typeNameEn;
        }

        public void setTypeNameEn(String typeNameEn) {
            this.typeNameEn = typeNameEn;
        }

        public List<PersonsBean> getPersons() {
            return persons;
        }

        public void setPersons(List<PersonsBean> persons) {
            this.persons = persons;
        }

        public static class PersonsBean {

            private int id;
            private String name;
            private String nameEn;
            private String image;

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

            public String getNameEn() {
                return nameEn;
            }

            public void setNameEn(String nameEn) {
                this.nameEn = nameEn;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}
