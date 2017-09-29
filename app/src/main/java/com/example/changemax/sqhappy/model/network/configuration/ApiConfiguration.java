package com.example.changemax.sqhappy.model.network.configuration;

/**
 * Created by ChangeMax on 2017/3/14.
 *
 */

public class ApiConfiguration {


    private int dataSourceType;

    public ApiConfiguration(Builder builder) {
        assert builder != null;
        initialize(builder);
    }

    private void initialize(Builder builder) {
        this.dataSourceType = builder.dataSourceType;
    }

    public int getDataSourceType() {
        return dataSourceType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private int dataSourceType;

        private Builder() {
        }

        public ApiConfiguration build() {
            return new ApiConfiguration(this);
        }

        public Builder dataSourceType(int dataSourceType) {
            this.dataSourceType = dataSourceType;
            return this;
        }
    }
}
