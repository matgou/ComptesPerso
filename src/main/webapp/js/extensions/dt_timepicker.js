angular.module('comptesPerso').
directive('dt', function(){
  return {
    require: '?ngModel',
    restrict: 'A',
    link: function ($scope, element, attrs, controller) {
          var updateModel, onblur;

          if (controller !== null) {

              updateModel = function () {
              	if (element.data("DateTimePicker").minViewMode === element.data("DateTimePicker").viewMode) {
	                    element.data("DateTimePicker").hide();
                      element.blur();
              	}
              };

              onblur = function () {
                  var date = element.datetimepicker().data("DateTimePicker").getMoment().toDate();
                  return $scope.$apply(function () {
                      return controller.$setViewValue(date);
                  });
              };

              controller.$render = function () {
                  var date = controller.$viewValue;
                  if (angular.isDefined(date) && date != null && moment.isMoment(date)) {
          			element.datetimepicker().data("DateTimePicker").date(date);
                  } else if (angular.isDefined(date)) {
                	  console.log(element.datetimepicker().data("DateTimePicker"));
                	  element.datetimepicker().data("DateTimePicker").date(moment(date));
                  }
                  return controller.$viewValue;
              };
          }
          return attrs.$observe('dt', function (value) {
              var options;
              options = { }; //<--- insert your own defaults here!
              if (angular.isObject(value)) {
                  options = value;
              }
              if (typeof (value) === "string" && value.length > 0) {
                  options = angular.fromJson(value);
              }
              return element.datetimepicker(options).on('change.dp', updateModel).on('blur', onblur);
          });
      }
  };
});
