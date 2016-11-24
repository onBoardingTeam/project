function loginInterceptor($location) {


    return {
        request: function (config) {
            // console.log(config);
            return config;
        },

        requestError: function (config) {
           // console.log(config);
            return config;
        },

        response: function (res) {
            //console.log(res);
            return res;
        },

        responseError: function (res) {
            console.log(res);
           if(res.status === 500){window.alert("you have requested more than once")}
           else if(res.status=== 401 || res.status ===403 ){$location.path('/')}
            return res;
        }
    }
}