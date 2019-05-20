;;interop and wrappers for ojAlgo optimization stuff
(ns cljopt.oj
  (:import  org.ojalgo.OjAlgoUtils
            [org.ojalgo.netio BasicLogger]
            [org.ojalgo.optimisation
             Expression
             ExpressionsBasedModel
             Optimisation
             Variable]))

;;debug is not necessary...
(defn debug! [])

;;probably want to wrap the ebm...
(defn ^ExpressionsBasedModel ->model [] (ExpressionsBasedModel.))

[0 :<= :bread :>= 10 :integer] ;;or
{:bread {:lower 0 :upper 10 :integer true}}





        // Create a new model.
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        // Add variables expressing servings of each of the considered foods
        // Set lower and upper limits on the number of servings as well as the weight (cost of a
        // serving) for each variable.
        Variable bread = model.addVariable("Bread").lower(0).upper(10).weight(0.05);
        Variable corn = model.addVariable("Corn").lower(0).upper(10).weight(0.18);
        Variable milk = model.addVariable("Milk").lower(0).upper(10).weight(0.23);

        // Create a vitamin A constraint.
        // Set lower and upper limits and then specify how much vitamin A a serving of each of the
        // foods contain.
        Expression vitaminA = model.addExpression("Vitamin A").lower(5000).upper(50000);
        vitaminA.set(bread, 0).set(corn, 107).set(milk, 500);

        // Create a calories constraint...
        Expression calories = model.addExpression("Calories").lower(2000).upper(2250);
        calories.set(bread, 65).set(corn, 72).set(milk, 121);

        // Solve the problem - minimise the cost
        Optimisation.Result result = model.minimise();

        // Print the result
        BasicLogger.debug();
        BasicLogger.debug(result);
        BasicLogger.debug();

        // Modify the model to require an integer valued solution.
        BasicLogger.debug("Adding integer constraints...");
        bread.integer(true);
        corn.integer(true);
        milk.integer(true);

        // Solve again
        result = model.minimise();

        // Print the result, and the model
        BasicLogger.debug();
        BasicLogger.debug(result);
        BasicLogger.debug();
        BasicLogger.debug(model);
BasicLogger.debug();

