(ns ebutuoy.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [ebutuoy.core-test]))

(doo-tests 'ebutuoy.core-test)
