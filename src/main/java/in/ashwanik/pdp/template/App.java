package in.ashwanik.pdp.template;

import lombok.Getter;

@Getter
public class App {
    private Arena arena;

    App() {
        arena = new JungleArena(new TreeMesh());
    }
}
