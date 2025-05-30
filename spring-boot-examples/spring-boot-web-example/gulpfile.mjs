import {dest, src} from "gulp";

const nodeModulesDir = "node_modules";
const targetDir = "src/main/webapp/static/libs";

const copyLibs = async () => {
    // jQuery
    src(nodeModulesDir + "/jquery/dist/jquery.js").pipe(
        dest(targetDir + "/jquery"),
    );

    src(nodeModulesDir + "/jquery/dist/jquery.min.js").pipe(
        dest(targetDir + "/jquery"),
    );

    // popperjs
    src(nodeModulesDir + "/@popperjs/core/dist/umd/popper.js").pipe(
        dest(targetDir + "/popperjs"),
    );

    src(nodeModulesDir + "/@popperjs/core/dist/umd/popper.min.js").pipe(
        dest(targetDir + "/popperjs"),
    );

    // Bootstrap
    src(nodeModulesDir + "/bootstrap/dist/**").pipe(
        dest(targetDir + "/bootstrap"),
    );

    // Layui
    src(nodeModulesDir + "/layui/dist/**").pipe(dest(targetDir + "/layui"));
};

const defaultTask = async () => {
    console.log("Copy libs.");
    await copyLibs().then();
};

export default defaultTask;
