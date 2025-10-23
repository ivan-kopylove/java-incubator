
# Incubator

> "Conceptual knowledge is not enough ... you must have the conviction that comes from personal experience." - The 9th Gyalwa Karmapa.

The project is an incubator - it contains different modules and serves different purposes:

- via-negativa 1 - a showcase: there are 1001 way to shoot yourself in the foot, but only a few to do according expectations. I have to recognize unexpected configurations as well;
- via-negativa 2 - a drop experiment: the MVP examples makes it easy to drop a component in order to check what will happen; unlike the big projects, it's easy to track relations what affects what;
- in form of runnables - the actual phenomenon that can be observed;
- pieces of apps' skeletons;
- if you gaze long into an abyss...: by checking the code again and again I internalized the structure so that I can easily recall it mentally;
- early stage projects: once a project is mature enough, I extract it into a separate project;
- atomic koans: predict what will be printed or fix something.

# Project-wide defaults

Wherever possible, the following project-wide defaults are applied project-wide.

## UUID structure

The project heavily relies on UUIDs as package names. This is the `value / CAPEX tradeoff` - the UUIDs might look ugly, but on the other hand eliminates the burden of coming up and then supporting package names.

Anyway, modules' names narrow the scope enough.

## Package-private

The examples intentionally violate DRY principle in the sake to make every example self-sufficient. 

The approach is tends to target a single concept at the moment.

No class reuse. No classes. Only a few `public` keywords.