package com.ish.annotation.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * Created by maqsoodi on 5/24/2017.
 */
@SupportedAnnotationTypes("com.ish.annotation.processor.Immutable")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class SimpleAnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        for (final Element element : roundEnv.getElementsAnnotatedWith(Immutable.class)) {

            if (element instanceof TypeElement) {
                final TypeElement typeElement = (TypeElement) element;

                for (final Element enclosedElement : typeElement.getEnclosedElements()) {
                    if (enclosedElement instanceof VariableElement) {
                        final VariableElement variableElement = (VariableElement) enclosedElement;
                        if (!variableElement.getModifiers().contains(Modifier.FINAL)) {
                            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                                    String.format(
                                            "Class '%s' is annotated as @Immutable, but field '%s' is not declared as final",
                                            typeElement.getSimpleName(), variableElement.getSimpleName()
                                    )
                            );
                        }
                    }
                }
            }
        }

        // Claiming that annotations have been processed by this processor
        return true;
    }
}
